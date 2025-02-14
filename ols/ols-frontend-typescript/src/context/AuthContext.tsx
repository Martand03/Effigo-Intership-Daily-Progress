import { createContext, useEffect, useState, ReactNode } from "react";
import { getToken, logoutUser } from "../service/authService";

interface AuthContextType {
  token: string | null;
  setToken: (newToken: string) => void;
  logout: () => void;
}

export const AuthContext = createContext<AuthContextType>({
  token: null,
  setToken: () => {},
  logout: () => {},
});

interface AuthProviderProps {
  children: ReactNode;
}

export function AuthProvider({ children }: AuthProviderProps) {
  const [token, setToken] = useState<string | null>(getToken());

  useEffect(() => {
    setToken(getToken());
  }, []);

  const login = (newToken: string) => {
    localStorage.setItem("token", newToken);
    setToken(newToken);
  };

  const logout = () => {
    logoutUser();
    setToken(null);
  };

  return (
    <AuthContext.Provider value={{ token, setToken: login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}
