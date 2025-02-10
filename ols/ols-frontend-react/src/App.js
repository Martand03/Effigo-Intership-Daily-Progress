import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import {AuthProvider} from "./context/AuthContext";
import Register from "./pages/Register";
import Login from "./pages/Login";
import PrivateRoute from "./component/PrivateRoute";
import Profile from "./pages/Profile";
import Dashboard from './pages/Dashboard';
import LandingPage from './pages/Landing';
import Logout from "./pages/Logout";
import AdminDashboard from "./pages/admin/AdminDashboard";
import Users from './pages/admin/Users';
import Category from './pages/admin/Category';
import Orders from './pages/admin/Orders';
import Courses from './pages/admin/Courses';
function App() {
  return (
    <div className="App">
      <AuthProvider>
        <Router>
          <Routes>
            <Route path='/' element={<LandingPage/>} />
            <Route path='/register' element={<Register/>} />
            <Route path='/login' element={<Login />} />
            <Route path='/logout' element={<Logout/>} />
            <Route element = {<PrivateRoute/>}>
              <Route path='/adminDashboard' element={<AdminDashboard/>} />
              <Route path='/profile' element={<Profile/>}/>
              <Route path='/dashboard' element={<Dashboard/>}/>
            </Route>
            <Route path='/admin/users' element={<Users/>}/>
            <Route path='/admin/categories' element={<Category/>} />
            <Route path="/admin/orders" element={<Orders/>} />
            <Route path='/admin/courses' element={<Courses/>} />
          </Routes>
        </Router>
      </AuthProvider>
    </div>
  );
}

export default App;
