import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";

const LandingPage = () => {
    const navigate = useNavigate();
  return (
    <div className="d-flex vh-100 justify-content-center align-items-center bg-primary text-white">
      <div className="text-center">
        <h1 className="display-4 fw-bold">Welcome to OLS System</h1>
        <p className="lead">By Martand, developed in Effigo Practice</p>
        <button type="button" className="btn btn-info" onClick={()=> navigate("/login")}>Login</button>
      </div>
    </div>
  );
};

export default LandingPage;
