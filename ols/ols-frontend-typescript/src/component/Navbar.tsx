import { useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
      <div className="container-fluid d-flex justify-content-between align-items-center">
        <h3 className="navbar-brand fw-bold" onClick={() => navigate("/dashboard")}>
          inEffigo
        </h3>

        <div className="flex-grow-1 d-flex justify-content-center">
          <span className="text-white fw-semibold">OLS</span>
        </div>

        <button className="btn btn-outline-light" onClick={() => navigate("/profile")}>
          Profile
        </button>
        <button className="btn btn-outline-light btn-danger ms-3" onClick={() => navigate("/logout")}>
          LogOut
        </button>
      </div>
    </nav>
  );
}

export default Navbar;
