import { useEffect, useState } from "react";
import { deleteTodoById, retreiveTodosByUsername } from "./api/TodosApi";
import { useAuth } from "./security/authContext";
import {useNavigate } from "react-router-dom";

export function ListTodoComponent(){

    // const today = new Date();
    // const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay());
    // const todos = [
    //     {id: 1, description: "Learn AWS", done: false, targetDate:targetDate},
    //     {id: 2, description: "Learn GCP", done: false, targetDate:targetDate},
    //     {id: 3, description: "Learn Azure", done: false, targetDate:targetDate},
    //     {id: 4, description: "Learn IBM", done: false, targetDate:targetDate}
    // ];

    const [todos, setTodos] = useState([]); 
    const [message, setMessage] = useState(null);
    const authContext = useAuth();
    const username = authContext.username;
    useEffect( () => refreshTodos() );
    const navigate = useNavigate();
    const refreshTodos = () =>{
        retreiveTodosByUsername(username)
        .then(response => {
            // console.log(response);
            setTodos(response.data);
        })
        .catch(error => console.log(error));
    };

    const deleteTodo = (id) => {
        // console.log("delete: " + id)
        deleteTodoById(username, id)
        .then(
            () => {
                setMessage(`Data for the id: ${id} deleted successfully...`);
            }
        )
    };

    const updateTodo = (id) => {
        navigate(`/todo/${id}`)
    };

    const handleAddTodo = () =>{
        navigate(`/addTodo/${username}`);
    };

    return(
        <div className="container">
            <h1>ToDo Applications </h1>
            {message && <p className="alert alert-warning">{message}</p>}
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Is Done</td>
                            <td>Target Date</td>
                            <td>Delete</td>
                            <td>Update</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate}</td>
                                        <td><button className="btn btn-danger" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-warning" onClick={() => updateTodo(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="d-flex justify-content-end">
                <button className="btn btn-success" onClick={handleAddTodo}>Add Todo +</button>
            </div>
        </div>
    )
}