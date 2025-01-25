import { createContext,useContext, useState } from "react";

export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);
export default function AuthProvider({children}){
    // const [number, setNumber] = useState(0);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const login = (username, password) =>{
        if(username === "Shiv" && password === "nandi"){
            setIsAuthenticated(true);
            setUsername(username);
            console.log("Good Request");
            return true;
        }else{
            setIsAuthenticated(false);
            setUsername(null);
            console.log("Bad Request");
            return false;
        }
    };

    const logout = () =>{
        setIsAuthenticated(false);
    };

    return(
        <AuthContext.Provider value={{isAuthenticated, login, logout, username}}>
            {children}
        </AuthContext.Provider>
    )
}