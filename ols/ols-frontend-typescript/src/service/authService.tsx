import axios from "axios";

const API_URL = 'http://localhost:8082/auth';

// Interfaces for user and course data
interface UserData {
  username: string;
  email: string;
  password: string;
}

interface Credentials {
  username: string;
  password: string;
}

interface CategoryData {
  name: string;
  description: string;
}

interface NewCourse {
  courseName: string;
  courseDescription: string;
  coursePrice: string | number;
}

// User registration
export const registerUser = async (userData: UserData) => {
  return axios.post(`${API_URL}/addNewUser`, userData);
};

// Login + get token
export const loginUser = async (credentials: Credentials) => {
  const response = await axios.post(`${API_URL}/generateToken`, credentials);

  if (response.data.token) {
    localStorage.setItem("token", response.data.token);
  }

  return response.data;
};

// Logout user
export const logoutUser = (): void => {
  localStorage.removeItem('token');
};

// Get token
export const getToken = (): string | null => {
  return localStorage.getItem("token");
};

// Get username from token
export const getUsernameFromToken = (): string | null => {
  const token = getToken();
  if (!token) return null;

  try {
    const payload = JSON.parse(atob(token.split(".")[1]));
    return payload.sub;
  } catch (error) {
    console.error("Error decoding token:", error);
    return null;
  }
};

// User profile
export const getUserProfile = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  const username = getUsernameFromToken();
  if (!username) throw new Error("Username not found in token");

  return axios.get(`${API_URL}/user/api/users/username/${username}`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
    withCredentials: true,
  });
};

// Get all courses
export const getCourses = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.get(`${API_URL}/user/api/courses`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
    withCredentials: true,
  });
};

// Enroll user in a course
export const enrollUserInCourse = async (userId: number, courseId: number) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.post(`${API_URL}/user/api/users/${userId}/enroll/${courseId}`, {}, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Order a course for user
export const orderCourse = async (userId: number, courseId: number, orderStatus: string) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.post(`${API_URL}/user/${userId}/createOrder/${courseId}`, null, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
    params: { orderStatus },
  });
};

// Update order status
export const updateCourseStatus = async (orderId: number, orderStatus: string) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.patch(`${API_URL}/user/${orderId}`, null, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
    params: { orderStatus },
  });
};

// Get all users (Admin)
export const getAllUsers = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.get(`${API_URL}/admin/api/users`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Get all categories (Admin)
export const getAllCategories = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.get(`${API_URL}/admin/api/category`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Add category (Admin)
export const addCategory = async (categoryData: CategoryData) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.post(`${API_URL}/admin/api/category`, categoryData, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Delete category (Admin)
export const deleteCategory = async (categoryId: number) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.delete(`${API_URL}/admin/api/category/${categoryId}`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Get all orders (Admin)
export const getAllOrders = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.get(`${API_URL}/admin/api/orders`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Get all courses (Admin)
export const getAllCourses = async () => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.get(`${API_URL}/admin/api/courses`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Delete course (Admin)
export const deleteCourse = async (courseId: number) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.delete(`${API_URL}/admin/api/courses/${courseId}`, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Add a course (Admin)
export const addCourse = async (newCourse: NewCourse) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.post(`${API_URL}/admin/api/courses`, {
    courseName: newCourse.courseName,
    courseDescription: newCourse.courseDescription,
    coursePrice: parseFloat(newCourse.coursePrice.toString()),
  }, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Assign course to category (Admin)
export const assignCourseToCategory = async (courseId: number, categoryId: number) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.post(`${API_URL}/admin/api/courses/${courseId}/assign/${categoryId}`, {}, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });
};

// Update user email
export const updateEmail = async (userId: number, userNewEmail: string) => {
  const token = getToken();
  if (!token) throw new Error("No auth token found");

  return axios.patch(`${API_URL}/user/api/users/${userId}/email`, {}, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
    params: { userNewEmail },
  });
};
