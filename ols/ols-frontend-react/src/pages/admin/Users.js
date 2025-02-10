import { useEffect, useState } from "react";
import { getAllUsers } from "../../service/authService";
import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./AdminNavbar";

const Users = () => {
    const [userData, setUserData] = useState(null);
    const [error, setError] = useState(null);
    const [expandedUser, setExpandedUser] = useState(null);

    useEffect(() => {
        const fetchUsersData = async () => {
            try {
                const response = await getAllUsers();
                setUserData(response.data);
            } catch (error) {
                console.error(error);
                setError("Error getting user details");
            }
        };

        fetchUsersData();
    }, []);

    const toggleDetails = (userId) => {
        setExpandedUser(expandedUser === userId ? null : userId);
    };

    if (error) {
        return <div className="alert alert-danger text-center">{error}</div>;
    }

    if (!userData) {
        return <div className="text-center mt-5"><strong>Loading...</strong></div>;
    }

    return (
        <div className="container mt-4">
            <AdminNavbar />
            <h1 className="text-center mb-4 text-success">All Users 📋</h1>
            <div className="row">
                {userData.length > 0 ? (
                    userData.map((user) => (
                        <div className="col-md-4 mb-4" key={user.userId}>
                            <div className="card shadow-lg border-0">
                                <div className="card-body text-center">
                                    <h5 className="card-title text-primary">{user.userName}</h5>
                                    <p className="card-text"><strong>User ID:</strong> {user.userId}</p>
                                    <p className="card-text"><strong>Email:</strong> {user.userEmail}</p>
                                    <button
                                        className="btn btn-primary mt-2"
                                        onClick={() => toggleDetails(user.userId)}
                                    >
                                        {expandedUser === user.userId ? "Hide Details" : "See More Details"}
                                    </button>
                                </div>

                                {expandedUser === user.userId && (
                                    <div className="card-footer text-left p-3">
                                        <h4 className="mt-3 bg-info">Orders</h4>
                                        {user.orders.length > 0 ? (
                                            user.orders.map((order) => (
                                                <div key={order.orderId} className="card p-2 mb-2 bg-light">
                                                    <p><strong>Order ID:</strong> {order.orderId}</p>
                                                    <p><strong>Status:</strong> {order.orderStatus}</p>
                                                    <p><strong>Amount:</strong> ₹{order.orderTotalAmount}</p>
                                                </div>
                                            ))
                                        ) : (
                                            <p>No orders found.</p>
                                        )}

                                        <h4 className="mt-3 bg-success">Enrolled Courses</h4>
                                        {user.courses.length > 0 ? (
                                            user.courses.map((course) => (
                                                <div key={course.courseId} className="card p-2 mb-2 bg-light">
                                                    <p><strong>Course ID:</strong> {course.courseId}</p>
                                                    <p><strong>Name:</strong> {course.courseName}</p>
                                                    <p><strong>Description:</strong> {course.courseDescription}</p>
                                                    <p><strong>Price:</strong> ₹{course.coursePrice}</p>
                                                    <p><strong>Category:</strong> {course.category ? course.category.categoryName : "N/A"}</p>
                                                </div>
                                            ))
                                        ) : (
                                            <p>No enrolled courses.</p>
                                        )}
                                    </div>
                                )}
                            </div>
                        </div>
                    ))
                ) : (
                    <p className="text-center">No users found.</p>
                )}
            </div>
        </div>
    );
};

export default Users;
