import { useState, useEffect } from "react";
import { getAllOrders } from "../../service/authService";
import AdminNavbar from "./AdminNavbar";


const Orders = () => {
    const [orderData, setOrderData] = useState(null);
    const [error, setError] = useState(null);

    useEffect(()=>{
        const fetchOrdersData = async () => {
                    try {
                        const response = await getAllOrders();
                        setOrderData(response.data);
                    } catch (error) {
                        console.error(error);
                        setError("Error getting user details");
                    }
                };
        
                fetchOrdersData();
    },[]);

    if (error) {
        return <div className="alert alert-danger text-center">{error}</div>;
    }

    if (!orderData) {
        return <div className="text-center mt-5"><strong>Loading...</strong></div>;
    }

    return(
        <div className="container mt-4">
            <AdminNavbar />
            <h1 className="text-center mb-4 text-warning">All Orders 🛒</h1>
            <div className="row">
                {orderData.length > 0 ? ( 
                    orderData.map((order) =>{

                        const bgColor = order.orderStatus === "PAID" ? "bg-success" : "bg-danger";

                        return(
                            <div className="col-md-4 mb-4" key={order.orderId}>
                                <div className="card shadow-lg border-0">
                                    <div className="card-body text-center">
                                        <p className="card-text text-primary"><strong>Order ID:</strong> {order.orderId}</p>
                                        <p className={`card-text text-${bgColor}`}><strong>Order Status:</strong> {order.orderStatus}</p>
                                        <p className="card-text"><strong>Order Total Amount:</strong> {order.orderTotalAmount}</p>
                                        <p className="card-text"><strong>User Id:</strong> {order.user.userId}</p>
                                        <p className="card-text"><strong>UserName:</strong> {order.user.userName}</p>
                                        <p className="card-text"><strong>User Email:</strong> {order.user.userEmail}</p>
                                    </div>
                                </div>
                            </div>
                        );
                    })
                ) : (
                    <p className="text-center">No users found.</p>
                )}
            </div>
        </div>
    )
};

export default Orders;