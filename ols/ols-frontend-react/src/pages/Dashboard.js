import { useState, useEffect } from "react";
import Navbar from "../component/Navbar";
import { getCourses, getUserProfile, orderCourse } from "../service/authService";
import "bootstrap/dist/css/bootstrap.min.css";
const Dashboard = () => {
    const [courses, setCourses] = useState([]);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true); 

    useEffect(() => {
        const fetchCourses = async () => {
            try {
                const response = await getCourses();
                const formattedCourses = response.data.map(course => ({
                    id: course.courseId,
                    title: course.courseName,
                    description: course.courseDescription,
                    price: course.coursePrice,
                    category: course.category ? course.category.categoryName : "No category available",
                }));
                setCourses(formattedCourses);
            } catch (error) {
                console.error("Error fetching courses:", error);
                setError("Failed to load courses");
            } finally {
                setLoading(false);
            }
        };

        fetchCourses();
    }, []);

    const handleOrder = async (courseId) => {
      try {
          const userData = getUserProfile();
          const userId = (await userData).data.userId;
          const orderStatus = "PENDING";
          const response = await orderCourse(userId, courseId, orderStatus);
          console.log("Order Successfull:", response.data);
          alert("Ordered successfully!");
      } catch (error) {
          console.error("Order failed:", error);
          alert("Order failed!");
      }
  };

    return (
        <div className="container py-5">
          <Navbar/>
          <h2 className="text-center mb-4 fw-bold">Available Courses</h2>
    
          {error && <p className="text-danger text-center">{error}</p>}
    
          {loading ? (
            <p className="text-center">Loading courses...</p>
          ) : (
            <div className="row g-4">
              {courses.length > 0 ? (
                courses.map((course) => (
                  <div key={course.id} className="col-md-6 col-lg-4">
                    <div className="card shadow-lg h-100 border-0">
                      <div className="card-body">
                        <h3 className="card-title fw-bold">{course.title}</h3>
                        <p className="card-text text-muted">{course.description}</p>
                        <p className="text-primary fw-semibold">Category: {course.category}</p>
                        <p className="text-success fw-bold">Price: ₹{course.price}</p>
                        <button type="button" className="btn btn-success" onClick={() =>handleOrder(course.id)}>OderNow</button>
                      </div>
                    </div>
                  </div>
                ))
              ) : (
                <p className="text-center">No courses available.</p>
              )}
            </div>
          )}
        </div>
      );
};

export default Dashboard;
