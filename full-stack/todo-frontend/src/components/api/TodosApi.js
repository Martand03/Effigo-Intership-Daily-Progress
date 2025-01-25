import axios from "axios";

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:3333/todos'
    }
)


export const retreiveTodosByUsername  = (username) => apiClient.get(`/${username}`);
export const deleteTodoById  = (username, id) => apiClient.delete(`/delete/${username}/${id}`);
export const retreiveTodoById  = (username, id) => apiClient.get(`/${username}/${id}`);
export const updateTodoById = (username, id, todo) => apiClient.put(`/${username}/${id}`, todo);
export const addTodo = (username, todo) => apiClient.post(`/${username}`, todo);
