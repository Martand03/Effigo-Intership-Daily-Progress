import './App.css';
import { useTable, useGlobalFilter, useSortBy, usePagination } from 'react-table';
import * as React from "react";
import { useState } from 'react';
import axios from 'axios';
function App() {

  const [employees, setEmployees] = useState([]);
  const columns = React.useMemo(()=>[
    {Header: "EmployeeId", accessor:"employeeId"},
    {Header: "Name", accessor:"name"},
    {Header: "Manager", accessor:"manager"},
    {Header: "Salary", accessor:"salary"},
    {Header: "Edit", id:"Edit", accessor:"edit" ,
      Cell:props=>(<button className='editBtn' onClick={() => handleUpdate(props.cell.row.original)}>Edit</button>)
    },
    {Header: "Delete", id:"Delete", accessor:"delete" ,
      Cell:props=>(<button className='deleteBtn' onClick={() => handleDelete(props.cell.row.original)}>Delete</button>)
    }
  ], []);

  // const data = React.useMemo(()=> employees, []);
  const [employeeData, setEmployeeData] = useState({name:"",manager:"",salary:""});
  const {getTableProps, getTableBodyProps, headerGroups, page, prepareRow, state, setGlobalFilter, pageCount, nextPage, previousPage, canNextPage, canPreviousPage, gotoPage} = useTable({columns, data:employees}, useGlobalFilter, useSortBy, usePagination);
  const [showCancel, setShowCancel] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const {globalFilter, pageIndex} = state;

  const getAllEmployees = () => {
    axios.get("http://localhost:8085/employees").then((res)=>{
      console.log(res.data);
      setEmployees(res.data);
    });
  };

  React.useEffect(()=>{
    getAllEmployees();
  },[]);

  const handleChange = (e) => {
    setEmployeeData({...employeeData, [e.target.name]:e.target.value});
    setErrorMessage("");
  };

  const handleSubmit = async(e) => {
    e.preventDefault();
    if (!employeeData.name || !employeeData.manager || !employeeData.salary) {
      setErrorMessage("All fields are required!");
      setShowCancel(true);
      return;  
    }
  
    setErrorMessage("");  
  
    
    if (employeeData.employeeId) {
      await axios
        .patch(`http://localhost:8085/employees/${employeeData.employeeId}`, employeeData)
        .then((res) => {
          console.log(res.data);
        });
    } else {
      await axios
        .post("http://localhost:8085/employees", employeeData)
        .then((res) => {
          console.log(res.data);
        });
    }
    
    getAll();
  };

  const getAll = () =>{
    setEmployeeData({name:"",manager:"",salary:""});
    getAllEmployees();
  };

  const handleUpdate = (emp) => {
    setEmployeeData(emp);
    setShowCancel(true);
  };

  const handleDelete = async(emp) => {
    const isConfirmed = window.confirm("Ar you sure to delete the record?");
    if(isConfirmed){
      await axios.delete(`http://localhost:8085/employees/${emp.employeeId}`).then((res) =>{
        console.log(res.data);
        getAllEmployees();
      });
    }
   
  };

  const handleCancel = () =>{
    setEmployeeData({name:"",manager:"",salary:""});
    setShowCancel(false);
    setErrorMessage("");
  };

  return (
    < div className="main-container">
    <div>
      <h3>ReactJS + SpringBoot + PostgreSQL Fullstack Project</h3>
      {errorMessage && <span>{errorMessage}</span>}
      <div className="add-panel">
        <div className="addpaneldiv">
          <label htmlFor ="name">Name: </label>
          <input className="addpanelinput" value={employeeData.name} onChange={handleChange} type="text" name="name" id="name" />
        </div>
        <div className="addpaneldiv">
          <label htmlFor ="manager">Manager: </label>
          <input className="addpanelinput" value={employeeData.manager} onChange={handleChange} type="text" name="manager" id="manager" />
        </div>
        <div className="addpaneldiv">
          <label htmlFor ="salary">Salary: </label>
          <input className="addpanelinput" value={employeeData.salary} onChange={handleChange} type="text" name="salary" id="salary" />
        </div>
        <br/>
         <button className="addBtn" onClick={handleSubmit}>{employeeData.employeeId ? "Update" : "Add"}</button>
         <button className="cancel" disabled={!showCancel} onClick={handleCancel}>Cancel</button>
      </div>
      <input className="inputsearch" value={globalFilter || ""} onChange={(e) => setGlobalFilter(e.target.value)} type="search"  name="inputsearch" id="inputsearch" placeholder="  Search Employee"/>
    </div>
    <table className='table' {...getTableProps()}>
      <thead>
        {headerGroups.map((hg)=>(
          <tr{...hg.getHeaderGroupProps()} key={hg.id}>
            {hg.headers.map((column)=>(
              <th {...column.getHeaderProps(column.getSortByToggleProps())} key={column.id}>{column.render("Header")}
              {column.isSorted && <span>{column.isSortedDesc ? "⬆️":"⬇️"}</span>}
              </th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {page.map((row)=>{
          prepareRow(row);
          return(
            <tr {...row.getRowProps()} key={row.id}>
              {row.cells.map((cell)=>(
                <td {...cell.getCellProps()} key={cell.id}>{cell.render("Cell")}</td>
              ))}
            </tr>
          )
        })}
      </tbody>
    </table>
      <div className="pageDiv">
        <button disabled={!canPreviousPage} className="pageBtn" onClick={()=>gotoPage(0)}>First</button>
        <button disabled={!canPreviousPage} className="pageBtn" onClick={previousPage}>Prev</button>
        <span className='idx'>{pageIndex+1} of {pageCount}</span>
        <button disabled={!canNextPage} className="pageBtn" onClick={nextPage}>Next</button>
        <button disabled={!canNextPage} className="pageBtn" onClick={()=>gotoPage(pageCount-1)}>Last</button>
      </div>
    </div>
  )
}

export default App;
