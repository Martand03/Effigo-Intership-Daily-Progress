import { ErrorMessage, Field, Form, Formik } from "formik";
import { addTodo } from "./api/TodosApi";
import { useAuth } from "./security/authContext";
import { useNavigate } from "react-router-dom";

export function AddTodo(){

    const authContext = useAuth();
    const username = authContext.username;
    const navigate = useNavigate();


    const handleOnSubmit = (values) =>{
            console.log(values);
            addTodo(username, values)
            .then(response => {
                console.log("Todo updated successfully:", response.data);
                navigate("/todos");
            })
            .catch(error => {
                console.error("Error updating todo:", error);
            });
        };

    const validate = (values) =>{
        let errors ={};

        if(values.description.length <5){
            errors.description = 'Enter atleast 5 characters'
        }

        if(values.targetDate == null){
            errors.description = 'Enter a target date'
        }

        return errors;
    }



    return(
        <div className="container mt-5">
            <h1 className="mb-4">Enter Todo Details To Be Added...</h1>
           <Formik
            initialValues={{
                description: "", targetDate:"", isDone:""
            }}
            onSubmit={handleOnSubmit}
            validate={validate}
            validateOnChange={false}
           >
            {
                (props) => (
                    <Form>
                        <div className="row col-md-8 offset-md-2">
                        <ErrorMessage
                            name="description"
                            component="div"
                            className="alert alert-warning"
                        />
                        <ErrorMessage
                            name="targetDate"
                            component="div"
                            className="alert alert-warning"
                        />
                        <fieldset>
                            <label>Description</label>
                            <Field type="text" className="form-control w-90" name="description"/>
                        </fieldset>
                        <fieldset>
                            <label>Target Date</label>
                            <Field type="date" className="form-control w-90" name="targetDate" />
                        </fieldset>
                        <fieldset>
                            <label>isDone</label>
                            <Field type="text" className="form-control w-90" name="isDone" />
                        </fieldset>
                        <div>
                            <button className="btn btn-success m-5" type="submit">Save</button>
                        </div>
                        </div>
                    </Form>
                )
            }
           </Formik>
        </div>
    )
}