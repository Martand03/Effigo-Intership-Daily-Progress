import { Navigate, Outlet } from "react-router-dom";
import {AuthContext} from "../context/AuthContext";
import { useContext } from "react";


const PrivateRoute = () => {
    const {token} = useContext(AuthContext);
    return token ? <Outlet/> : <Navigate to="/login" />;
};

export default PrivateRoute;