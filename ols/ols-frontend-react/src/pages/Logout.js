import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import { getUsernameFromToken, logoutUser } from "../service/authService";

const Logout = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        logoutUser();
        navigate("/");
    };

    const userName = getUsernameFromToken();

    return (
        <div className="d-flex justify-content-center align-items-center vh-100">
            <div className="p-4 text-center shadow-lg bg-white rounded" style={{ width: "350px" }}>
                <h4 className="mb-3">Are you sure you want to logout?</h4>
                <div className="d-flex justify-content-between">
                    <button className="btn btn-danger" onClick={handleLogout}>
                        Yes, Logout
                    </button>
                    {userName === "admin" ? (
                        <button className="btn btn-secondary" onClick={() => navigate("/adminDashboard")}>
                            No, Go Back
                        </button>
                    ) : (
                        <button className="btn btn-secondary" onClick={() => navigate("/dashboard")}>
                            No, Go Back
                        </button>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Logout;
