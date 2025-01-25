import { useParams } from "react-router-dom"
import { Link } from "react-router-dom";
export function Welcome(){

    const {username} = useParams();

    return(
        <div>
           <h1>Welcome {username} !!</h1>
           <div>
                <h3>Manage your Todos ➡️ <Link to="/todos">Go Here</Link> </h3>
           </div>
        </div>
    )
}