import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./AdminNavbar";

const AdminDashboard = () => {
    const navigate = useNavigate();

    return (
        <div className="container mt-5">
            <AdminNavbar/>
            <h2 className="text-center mb-4 mt-4">Admin Dashboard</h2>
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="card shadow-lg p-4">
                        <div className="text-center mb-3">
                            <h4>Manage Platform</h4>
                        </div>
                        <div className="d-grid gap-3">
                            <button className="btn btn-primary" onClick={() => navigate("/admin/users")}>
                                📋 View All Users
                            </button>
                            <button className="btn btn-success" onClick={() => navigate("/admin/categories")}>
                                🗂 View All Categories
                            </button>
                            <button className="btn btn-warning" onClick={() => navigate("/admin/courses")}>
                                📚 View All Courses
                            </button>
                            <button className="btn btn-danger" onClick={() => navigate("/admin/orders")}>
                                🛒 View All Orders
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AdminDashboard;
