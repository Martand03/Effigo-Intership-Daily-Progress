import  { useState, useEffect } from "react";
import {enrollUserInCourse, getUserProfile, updateCourseStatus, updateEmail} from "../service/authService";
import Navbar from "../component/Navbar"
import 'bootstrap/dist/css/bootstrap.min.css';

const Profile = () => {
    const [profile, setProfile] = useState(null);
    const [error, setError] = useState(null);
    const [newUserEmail, setNewUserEmail] = useState("");
    const [isEditing, setIsEditing] = useState(false);

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const response = await getUserProfile();
                setProfile(response.data);
            } catch (error) {
                console.error(error);
                setError("Error getting details");
            }
        };

        fetchProfile();
    }, []);

    const handleBuyNow = async (orderId) => {
        try {
            const newOrderStatus = "PAID";
            updateCourseStatus(orderId, newOrderStatus);
            alert("Course Buy successfull!");
            window.location.reload();
        } catch (error) {
            console.error("Buy failed");
            alert("Course Buy Failed");
        }
    }

    const handleEnrollNow = async (courseId) => {
        try {
            const userId = profile.userId;
            enrollUserInCourse(userId, courseId);
            alert("Enrolled in Course Successfully");
            window.location.reload();
        } catch (error) {
            console.error("Enrollment failed");
            alert("Enrollment failed in course");
        }
    };

    const handleEditEmail = async (userId) => {
        if (!newUserEmail) {
            alert("Please enter a new email.");
            return;
        }
        try{
            updateEmail(userId, newUserEmail);
            alert("Email Updated");
            window.location.reload();
        }catch(error){
            console.error("Updating user email failed");
            alert("User email update failed");
        }
    }


    if (error) {
        return <div>{error}</div>;
    }

    if (!profile) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container py-5">
            <Navbar />

            <div className="container mt-4">
                <div className="card p-4 shadow-sm bg-primary text-white">
                    <h2 className="mb-4">Profile Details</h2>
                    <p><strong>User ID:</strong> {profile.userId}</p>
                    <p><strong>Name:</strong> {profile.userName}</p>
                    <p>
                        <strong>Email: </strong>
                        {isEditing ? (
                            <>
                                <input 
                                    type="email" 
                                    value={newUserEmail} 
                                    onChange={(e) => setNewUserEmail(e.target.value)} 
                                    placeholder="Enter new email"
                                />
                                <button className="btn btn-sm" onClick={() => handleEditEmail(profile.userId)}>✅</button>
                                <button className="btn btn-sm" onClick={() => setIsEditing(false)}>❌</button>
                            </>
                                ) : (
                            <>
                                {profile.userEmail} 
                                <button className="btn btn-sm" onClick={() => setIsEditing(true)}>✏️</button>
                            </>
                        )}
                    </p>
                </div>

                <h3 className="mt-4 text-primary">My Orders</h3>
                <div className="row">
                    {profile.orders.length > 0 ? (
                        profile.orders.map((order, index) => {
                            const bgColor = order.orderStatus === "PAID" ? "bg-success" : "bg-danger";
                            return (
                                <div key={index} className="col-md-4">
                                    <div className={`card shadow-sm p-3 mb-3 text-black ${bgColor}`}>
                                        <div className="card-body">
                                            <h5 className="card-title">Order {index + 1}</h5>
                                            <p><strong>Order ID:</strong> {order.orderId}</p>
                                            <p><strong>Status:</strong> {order.orderStatus}</p>
                                            <p><strong>Total Amount:</strong> ₹{order.orderTotalAmount}</p>
                                            <p><strong>Course:</strong> {order.course.courseName}</p>
                                            {order.orderStatus === "PENDING" ? (
                                                <button className="btn btn-success" onClick={() => handleBuyNow(order.orderId)}>Buy Now</button>
                                            ) : (
                                                !profile.courses.some((c) => c.courseId === order.course.courseId) && (
                                                    <button className="btn btn-warning" onClick={() => handleEnrollNow(order.course.courseId)}>Enroll Now</button>
                                                )
                                            )}
                                        </div>
                                    </div>
                                </div>
                            );
                        })
                    ) : (
                        <p>No orders found.</p>
                    )}
                </div>

                <h3 className="mt-4 text-primary">My Enrolled Courses</h3>
                <div className="row">
                    {profile.courses.length > 0 ? (
                        profile.courses.map((course, index) => (
                            <div key={index} className="col-md-4">
                                <div className="card shadow-sm p-3 mb-3 bg-info text-white">
                                    <div className="card-body">
                                        <h5 className="card-title">{course.courseName}</h5>
                                        <p className="card-text">{course.courseDescription}</p>
                                        <p><strong>Price:</strong> ₹{course.coursePrice}</p>
                                        <p><strong>Category:</strong> {course.category ? course.category.categoryName : "No Category"}</p>
                                    </div>
                                </div>
                            </div>
                        ))
                    ) : (
                        <p>No courses found.</p>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Profile;
