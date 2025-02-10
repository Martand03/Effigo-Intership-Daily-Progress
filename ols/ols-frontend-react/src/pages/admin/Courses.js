import { useEffect, useState } from "react";
import { deleteCourse, getAllCourses, addCourse, getAllCategories, assignCourseToCategory } from "../../service/authService";
import AdminNavbar from "./AdminNavbar";


const Courses = () => {

    const [error, setError] = useState("");
    const [courses, setCourses] = useState(null);
    const [showForm, setShowForm] = useState(false);

    const [courseName, setCourseName] = useState("");
    const [courseDescription, setCourseDescription] = useState("");
    const [coursePrice, setCoursePrice] = useState("");

    const [categories, setCategories] = useState([]); 
    const [selectedCategory, setSelectedCategory] = useState("");

    useEffect(()=>{
        fetchCoursesData();
        fetchCategories();
    },[]);

    const toggleForm = () => {
        setShowForm(!showForm);
    };

    const fetchCoursesData = async () => {
        try {
            const response = await getAllCourses();
            setCourses(response.data);
        } catch (error) {
            console.error(error);
            setError("Error getting courses details");
        }
    };

    const fetchCategories = async () => {
        try {
            const response = await getAllCategories();
            setCategories(response.data);
        } catch (error) {
            console.error("Error fetching categories:", error);
            setError("Error fetching categories");
        }
    };

    const handleDeleteCourse = async (courseId) => {
        try {
            await deleteCourse(courseId);
            alert("Course delete successfully");
            fetchCoursesData();
        } catch (error) {
            console.error("Error deleting course:", error);
            alert("Failed to delete course.");
        }
    };

    const handleAddCourse = async (e) => {
        e.preventDefault();

        const newCourse = {
            courseName,
            courseDescription,
            coursePrice: parseFloat(coursePrice)
        };

        try {
            const response = await addCourse(newCourse);
            const courseId = response.data.courseId;
            console.log("Course added:", response.data);
            if (selectedCategory) {
                await assignCourseToCategory(courseId, selectedCategory);
                console.log("Category assigned successfully!");
            }
            alert("Course added successfully!");

            setCourseName("");
            setCourseDescription("");
            setCoursePrice("");
            setSelectedCategory("");
            setShowForm(false);

            fetchCoursesData();
        } catch (error) {
            console.error("Error adding course:", error);
            alert("Failed to add course.");
        }

    };

    if (error) {
        return <div className="alert alert-danger text-center">{error}</div>;
    }

    if (!courses) {
        return <div className="text-center mt-5"><strong>Loading...</strong></div>;
    }

    return(
        <div className="container mt-4">

            <AdminNavbar/>
            <h1 className="text-center text-danger mb-4">All Courses 📚</h1>
            <button className="btn btn-success mb-5" onClick={toggleForm}>
                {showForm ? "Close Form" : "+ Add Course"}
            </button>

            {showForm && (
                <div className="card p-4 mb-4 shadow-lg">
                    <h5 className="text-center">Add New Course</h5>
                    <form onSubmit={handleAddCourse}>
                        <div className="mb-3">
                            <label className="form-label">Course Name: </label>
                            <input
                                type="text"
                                className="form-control"
                                value={courseName}
                                onChange={(e) => setCourseName(e.target.value)}
                                required
                            />
                            <label className="form-label">Course Description: </label>
                            <input
                                type="text"
                                className="form-control"
                                value={courseDescription}
                                onChange={(e) => setCourseDescription(e.target.value)}
                                required
                            />
                            <label className="form-label">Course Price: ₹</label>
                            <input
                                type="text"
                                className="form-control"
                                value={coursePrice}
                                onChange={(e) => setCoursePrice(e.target.value)}
                                required
                            />

                            <label className="form-label">Category:</label>
                            <select className="form-control" value={selectedCategory} onChange={(e) => setSelectedCategory(e.target.value)} required>
                                <option value="">Select Category</option>
                                {categories.map((category) => (
                                    <option key={category.categoryId} value={category.categoryId}>
                                        {category.categoryName}
                                    </option>
                                ))}
                            </select>

                        </div>
                        <div className="text-center">
                            <button type="submit" className="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>
            )}

            <div className="row">
                {courses.length > 0 ? (
                    courses.map((course) => (
                        <div key={course.courseId} className="col-md-4 mb-4">
                            <div className="card shadow-lg border-0">
                                <div className="card-body text-center">
                                    <div className="card p-3 mb-2 bg-light" key={course.courseId}>
                                        <button className="btn btn-danger btn-sm position-absolute top-0 end-0 m-2" onClick={()=>handleDeleteCourse(course.courseId)}>
                                            🗑️ Delete
                                        </button>
                                        <p><strong>Course ID:</strong> {course.courseId}</p>
                                        <p><strong>Name:</strong> {course.courseName}</p>
                                        <p><strong>Description:</strong> {course.courseDescription}</p>
                                        <p><strong>Price:</strong> ₹{course.coursePrice}</p>
                                        <p><strong>Category:</strong> {course.category?.categoryName || "No Category Assigned"}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))
                ) : (
                    <div className="col-12 text-center">
                        <p className="alert alert-warning">No Courses found.</p>
                    </div>
                )}
            </div>
        </div>
    )
};

export default Courses;