import './App.css';
import TodoApp from './components/TodoApp';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import { Welcome } from './components/Welcome';
import { ErrorComponent } from './components/ErrorComponent';
import { ListTodoComponent } from './components/ListTodoComponent';
import { Header } from './components/Header';
import { Footer } from './components/Footer';
import { LogoutComponent } from './components/LogoutComponent';
import { Login } from './components/Login';
import  AuthProvider, { useAuth }  from './components/security/authContext';
import { TodoDetails } from './components/TodoDetails';
import { AddTodo } from './components/AddTodo';
function App() {

  const AuthenticatedRoute = ({children}) =>{
    const authContext = useAuth();
    if(authContext.isAuthenticated){
      return children;
    }
    return <Navigate to="/"></Navigate>
  };

  return (
    <div className="App">
      <AuthProvider>
      <BrowserRouter>
      <Header/>
        <Routes>
          <Route path='/' element={<TodoApp />} />
          <Route path='/welcome/:username' element={
            <AuthenticatedRoute>
              <Welcome />
            </AuthenticatedRoute>
          } />
          <Route path='*' element={<ErrorComponent />} />
          <Route path="/todos" element={
            <AuthenticatedRoute>
              <ListTodoComponent/>
            </AuthenticatedRoute>
          } />
          <Route path='/logout' element={
            <AuthenticatedRoute>
              <LogoutComponent/>
            </AuthenticatedRoute>
          } />
          <Route path='/todo/:id' element={
            <AuthenticatedRoute>
              <TodoDetails/>
            </AuthenticatedRoute>
            } />
          <Route path='/addTodo/:username' element={
            <AuthenticatedRoute>
              <AddTodo/>
            </AuthenticatedRoute>
            } />
          <Route path='/login' element={<Login/>} />
        </Routes>
        <Footer/>
      </BrowserRouter>
      </AuthProvider>
    </div>
  );
}

export default App;
