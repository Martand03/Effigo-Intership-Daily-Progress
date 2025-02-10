import { useContext} from "react"
import {AuthContext} from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { getUsernameFromToken, loginUser } from "../service/authService";
import "bootstrap/dist/css/bootstrap.min.css";
const Login = () => {
    const {setToken} = useContext(AuthContext);
    const navigate = useNavigate();

    const handleLogin = async (e) => {
      e.preventDefault();
      const credentials = {
        username: e.target.username.value,
        password: e.target.password.value,
      };

      try {
        const data = await loginUser(credentials);
        setToken(data.token);
        alert("Login successful!");
        const userName = getUsernameFromToken();
        if(userName === "admin"){
          navigate("/adminDashboard");
        }else{
          navigate("/dashboard");
        }
      } catch (error) {
        console.error(error);
        alert("Invalid credentials");
      }
    };

    return (
      <div className="d-flex vh-100 justify-content-center align-items-center bg-light">
        <div className="card p-4 shadow-lg" style={{ width: "350px", borderRadius: "10px" }}>
          <h2 className="text-center mb-4">Login</h2>
          <form onSubmit={handleLogin}>
            <div className="mb-3">
              <input
                type="text"
                name="username"
                className="form-control"
                placeholder="Username"
                required
              />
            </div>
            <div className="mb-3">
              <input
                type="password"
                name="password"
                className="form-control"
                placeholder="Password"
                required
              />
            </div>
            <button type="submit" className="btn btn-primary w-100">
              Login
            </button>
            <p className="mt-2">If New ? Join Us <span onClick={()=>navigate("/register")} className="link-underline-primary text-primary">Register</span></p>
          </form>
        </div>
      </div>
    );

};

export default Login;