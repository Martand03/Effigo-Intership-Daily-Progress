import {useState } from "react"
import {useNavigate } from "react-router-dom";
import {useAuth} from "./security/authContext";
export function Login(){

    const[ username, setUsername] = useState();
    const[ password, setPassword] = useState();
    const[ showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    const handleUsernameChange = (e) =>{
        // console.log(e.target.value);
        setUsername(e.target.value);
    }

    const handlePasswordChange = (e) =>{
        // console.log(e.target.value);
        setPassword(e.target.value);
    }

    const handleSubmit = () => {
        if(authContext.login(username, password)){
            setShowErrorMessage(false);
            navigate(`/welcome/${username}`);
        }else{
            console.log("Bad Request");
            setShowErrorMessage(true);
        }
    }

    return(
        <div className="Login">
            {showErrorMessage && (
                <div className="errorMessage">
                Authentication Failed. Please check your credentials.
                </div>
            )}
            <div className="d-flex justify-content-center align-items-center">
                <div className="card p-4 shadow-lg" style={{ maxWidth: "400px", width: "100%" }}>
                    <h2 className="text-center mb-4">Login</h2>
                    <form>
                        <div className="mb-3">
                            <label htmlFor="username" className="form-label">Username</label>
                            <input
                                type="text"
                                className="form-control"
                                id="username"
                                name="username"
                                value={username}
                                onChange={handleUsernameChange}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input
                                type="password"
                                className="form-control"
                                id="password"
                                name="password"
                                value={password}
                                onChange={handlePasswordChange}
                            />
                        </div>
                        <button
                            type="button"
                            className="btn btn-primary w-100"
                            name="login"
                            onClick={handleSubmit}
                        >
                            Login
                        </button>
                    </form>
                </div>
            </div>
        </div>
    )
}