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
            <div className="LoginForm">
                <div>
                    <label>Username: </label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <button name="login" onClick={handleSubmit}>Login</button>
            </div>
        </div>
    )
}