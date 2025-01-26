import { useNavigate, useParams } from "react-router-dom"
import { retreiveTodoById, updateTodoById } from "./api/TodosApi";
import { useEffect, useState } from "react";
import { useAuth } from "./security/authContext";
import { Field, Formik, Form, ErrorMessage } from "formik";

export function TodoDetails(){

    const {id} = useParams();
    const authContext = useAuth();
    const username = authContext.username;
    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');
    const navigate = useNavigate();

    useEffect(
        () => retreiveTodos(),
        // eslint-disable-next-line react-hooks/exhaustive-deps
        [id]
    )

    const retreiveTodos = () =>{
        retreiveTodoById(username,id)
        .then(response => {
            setDescription(response.data.description)
            setTargetDate(response.data.targetDate)
        })
        .catch(error => console.log(error))
    };

    const handleOnSubmit = (values) =>{
        console.log(values);
        updateTodoById(username, id, values)
        .then(response => {
            console.log("Todo updated successfully:", response.data);
            navigate("/todos");
        })
        .catch(error => {
            console.error("Error updating todo:", error);
        });
    };

    const validate = (values) =>{
        let errors ={
            // description: 'Enter a valid description',
            // targetDate: 'Enter a valid date'
        }

        if(values.description.length <5){
            errors.description = 'Enter atleast 5 characters'
        }

        if(values.targetDate == null){
            errors.description = 'Enter a target date'
        }

        return errors;
    }


    return(
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{description, targetDate}}
                 enableReinitialize={true}
                 onSubmit={handleOnSubmit}
                 validate={validate}
                 validateOnChange={false}
                 >
                    {
                        (props) => (
                            <Form>
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
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description"/>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate"/>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                    <button className="btn btn-danger" onClick={() => navigate("/todos")}>Cancel</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}