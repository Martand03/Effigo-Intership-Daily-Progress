import { createContext, useEffect, useState } from "react";
import {getToken, logoutUser} from "../service/authService";

export const AuthContext = createContext();

export const AuthProvider = ({children}) => {
    const [token, setToken] = useState(getToken());

    useEffect(() => {
        setToken(getToken());
    }, []);

    const login = (newToken) => {
        localStorage.setItem("token", newToken);
        setToken(newToken);
      };

    const logout = () => {
        logoutUser();
        setToken(null);
    };

    return(
        <AuthContext.Provider value={{token, setToken: login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}