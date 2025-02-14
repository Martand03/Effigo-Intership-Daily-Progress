import { useEffect, useState } from "react";
import { getAllCategories, addCategory, deleteCategory } from "../../service/authService";
import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./AdminNavbar";

interface Course {
  courseId: number;
  courseName: string;
  courseDescription: string;
  coursePrice: number;
}

interface Category {
  categoryId: number;
  categoryName: string;
  courses: Course[];
}

const Category = () => {
  const [categories, setCategories] = useState<Category[] | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [expandedCategory, setExpandedCategory] = useState<number | null>(null);
  const [showForm, setShowForm] = useState<boolean>(false);
  const [categoryName, setCategoryName] = useState<string>("");

  useEffect(() => {
    fetchCategoryData();
  }, []);

  const fetchCategoryData = async () => {
    try {
      const response = await getAllCategories();
      setCategories(response.data);
    } catch (error) {
      console.error(error);
      setError("Error getting category details");
    }
  };

  const toggleCourses = (categoryId: number) => {
    setExpandedCategory(expandedCategory === categoryId ? null : categoryId);
  };

  const toggleForm = () => {
    setShowForm(!showForm);
  };

  const handleAddCategory = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!categoryName.trim()) {
      alert("Category name cannot be empty..");
      return;
    }
    try {
      const newCategory = { categoryName };
      await addCategory(newCategory);
      alert("Category added successfully...");
      setCategoryName("");
      setShowForm(false);
      fetchCategoryData();
    } catch (error) {
      console.error("Error adding category:", error);
      alert("Failed to add category.");
    }
  };

  const handleDeleteCategory = async (categoryId: number) => {
    try {
      await deleteCategory(categoryId);
      alert("Category deleted successfully");
      fetchCategoryData();
    } catch (error) {
      console.error("Error deleting category:", error);
      alert("Failed to delete category.");
    }
  };

  if (error) {
    return <div className="alert alert-danger text-center">{error}</div>;
  }

  if (!categories) {
    return <div className="text-center mt-5"><strong>Loading...</strong></div>;
  }

  return (
    <div className="vw-100 container mt-2">

      <AdminNavbar />

      <h1 className="text-center text-primary mb-4">All Categories 🗂</h1>

      <div className="text-center mb-4">
        <button className="btn btn-success" onClick={toggleForm}>
          {showForm ? "Close Form" : "Add Category"}
        </button>
      </div>

      {showForm && (
        <div className="card p-4 mb-4 shadow-lg">
          <h5 className="text-center">Add New Category</h5>
          <form onSubmit={handleAddCategory}>
            <div className="mb-3">
              <label className="form-label">Category Name</label>
              <input
                type="text"
                className="form-control"
                value={categoryName}
                onChange={(e) => setCategoryName(e.target.value)}
                required
              />
            </div>
            <div className="text-center">
              <button type="submit" className="btn btn-primary">Submit</button>
            </div>
          </form>
        </div>
      )}

      <div className="row">
        {categories.length > 0 ? (
          categories.map((category) => (
            <div key={category.categoryId} className="col-md-4 mb-4">
              <div className="card shadow-lg border-0">
                <div className="card-body text-center">
                  <button
                    className="btn btn-danger btn-sm position-absolute top-0 end-0 m-2"
                    onClick={() => handleDeleteCategory(category.categoryId)}
                  >
                    🗑️ Delete
                  </button>
                  <h5 className="card-title text-dark">{category.categoryName}</h5>
                  <p className="card-text">
                    <strong>Category ID:</strong> {category.categoryId}
                  </p>
                  <button
                    className="btn btn-primary mt-2"
                    onClick={() => toggleCourses(category.categoryId)}
                  >
                    {expandedCategory === category.categoryId ? "Hide Courses" : "See Courses"}
                  </button>
                </div>
              </div>

              {expandedCategory === category.categoryId && (
                <div className="mt-3">
                  <h4 className="text-center bg-info">Courses</h4>
                  {category.courses.length > 0 ? (
                    category.courses.map((course) => (
                      <div className="card p-3 mb-2 bg-light" key={course.courseId}>
                        <p><strong>Course ID:</strong> {course.courseId}</p>
                        <p><strong>Name:</strong> {course.courseName}</p>
                        <p><strong>Description:</strong> {course.courseDescription}</p>
                        <p><strong>Price:</strong> ₹{course.coursePrice}</p>
                      </div>
                    ))
                  ) : (
                    <p className="text-center">No courses available.</p>
                  )}
                </div>
              )}
            </div>
          ))
        ) : (
          <div className="col-12 text-center">
            <p className="alert alert-warning">No categories found.</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default Category;
