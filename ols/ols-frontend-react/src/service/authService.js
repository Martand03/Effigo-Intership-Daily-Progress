import axios from "axios";


const API_URL = 'http://localhost:8082/auth';

//user registration

export const registerUser = async (userData) => {
    return axios.post(`${API_URL}/addNewUser`, userData);
};


// login + get token
export const loginUser = async (credentials) => {
    const response = await axios.post(`${API_URL}/generateToken`, credentials);
    // console.log("Login Response:", response.data); // Debugging

    if(response.data.token){
        localStorage.setItem("token", response.data.token);
        // console.log("Token saved:", localStorage.getItem("token")); // Debugging
    }

    return response.data;
}

// logout user

export const logoutUser = () => {
    localStorage.removeItem('token');
}

// get token
export const getToken = () => {
    const token = localStorage.getItem("token");
    // console.log("Retrieved Tokenjkbjdfjfjfakbffkbfakb:", token); // Debugging
    return token;
}

//get username
export const getUsernameFromToken = () => {
    const token = localStorage.getItem("token");
    if (!token) return null;

    try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        return payload.sub; 
    } catch (error) {
        console.error("Error decoding token:", error);
        return null;
    }
};

//user profile

export const getUserProfile = async () => {
    const token = getToken();
    if (!token) {
        throw new Error("No auth token found");
    }
    const username = getUsernameFromToken();
    if(!username){
        throw new Error("Username not found in token");
    }

    return axios.get(`${API_URL}/user/api/users/username/${username}`, {
        headers : {
            'Authorization': `Bearer ${token}`,
            'Content-Type':'application/json'
            },
            credentials: 'include'
    });
};


// get all courses
export const getCourses = async () => {
    const token = getToken();
    if (!token) {
        throw new Error("No auth token found");
    }

    return axios.get(`${API_URL}/user/api/courses`,{
        headers : {
            'Authorization': `Bearer ${token}`,
            'Content-Type':'application/json'
            },
            credentials: 'include'
    });
};

// enroll user in a course
export const enrollUserInCourse = async (userId, courseId) => {
    const token = getToken();
    if (!token) {
        throw new Error("No auth token found");
    }

    return axios.post(`${API_URL}/user/api/users/${userId}/enroll/${courseId}`, {}, {
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        }
    });
};


// order a course for user
export const orderCourse = async (userId, courseId, orderStatus) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.post(`${API_URL}/user/${userId}/createOrder/${courseId}`,null,
        {
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            },
            params:{orderStatus},
        });
};

// update status of pending or paid
export const updateCourseStatus = async (orderId, orderStatus) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.patch(`${API_URL}/user/${orderId}`,null,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        params:{orderStatus},
    });
}

// get all users
export const getAllUsers = async () => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.get(`${API_URL}/admin/api/users`,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    })
};

//get all categories
export const getAllCategories = async () => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }

    return axios.get(`${API_URL}/admin/api/category`,{
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type':'application/json'
        },
    })
};


//add category
export const addCategory = async (categoryData) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }

    return axios.post(`${API_URL}/admin/api/category`,categoryData,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    });
};

// delete category
export const deleteCategory = async (categoryId) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }

    return axios.delete(`${API_URL}/admin/api/category/${categoryId}`,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    });
};

// get all orders
export const getAllOrders = async () =>{
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.get(`${API_URL}/admin/api/orders`,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    })
};

// get all courses
export const getAllCourses = async () => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.get(`${API_URL}/admin/api/courses`,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    })
};

// delete course
export const deleteCourse = async (courseId) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.delete(`${API_URL}/admin/api/courses/${courseId}`,{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    })
};

// add a course 
export const addCourse = async (newCourse) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.post(`${API_URL}/admin/api/courses`,{
        courseName: newCourse.courseName,
        courseDescription: newCourse.courseDescription,
        coursePrice: parseFloat(newCourse.coursePrice)
    },{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    })
};

//add course to category
export const assignCourseToCategory = async (courseId, categoryId) => {
    const token = getToken();
    if (!token) throw new Error("No auth token found");

    return axios.post(`${API_URL}/admin/api/courses/${courseId}/assign/${categoryId}`, {}, {
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    });
};

// update user email
export const updateEmail = async (userId, userNewEmail) => {
    const token = getToken();
    if(!token){
        throw new Error("No auth token found");
    }
    return axios.patch(`${API_URL}/user/api/users/${userId}/email`,{},{
        headers:{
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        params:{userNewEmail},
    })
};
