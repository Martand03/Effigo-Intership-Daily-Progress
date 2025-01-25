// import "./css/header.css";
import {useAuth} from "./security/authContext";
import { Link } from "react-router-dom"
export function Header(){
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;

    const logout = () =>{
        authContext.logout();
    };
    
    return(
        <div className="border-bottom border-light border-5 mb-5 p-2">
            <div className="row">
                <nav className="navbar navbar-expand-lg">
                 <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="http://localhost:3000/">inEffigo</a>
                 <div className="collapse navbar-collapse">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            {isAuthenticated && <Link className="nav-link" to="/welcome/Shiv">Home</Link>}
                        </li>
                        <li className="nav-item">
                            {isAuthenticated && <Link className="nav-link" to="/todos">Todos</Link>}
                        </li>
                    </ul>
                 </div>
                 <div className="navbar-nav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            {!isAuthenticated && <Link className="nav-link" to="/login">Login</Link>}
                        </li>
                        <li className="nav-item"><Link className="nav-link" to="/logout" onClick={logout}>Logout</Link></li> 
                    </ul>
                 </div>
                </nav>
            </div>
        </div>
    )
}