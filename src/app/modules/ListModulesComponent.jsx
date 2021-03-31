import React, { Component } from 'react'
import UserService from '../services/UserService'
import Table from 'react-bootstrap/Table'


class ListModulesComponent extends Component{
    constructor(props){
        super(props)

        this.state = {
            modules: []

        }
        
    }
    

    componentDidMount(){
        UserService.getModules().then((res) => {
            this.setState({modules: res.data});
        });
    }


    render(){
        return(
            <div>
                 <h2 className = "text-center">Modules</h2>
                 <div className = "row">
                    
                 </div>
                    <div className = "row">
                    <Table striped bordered hover>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>description</th>
                                    <th>lecturerID</th>
                                    
                                    
                                </tr>
                            </thead>

                            <tbody>
                                {

                                    this.state.modules.map(
                                        module =>
                                        <tr key = {module.id}>
                                            <td>{module.id}</td>
                                            <td> {module.title}</td>
                                            <td> {module.description}</td>
                                            <td> {module.lecturerID}</td>
                                            
                                           
                                        </tr>
                                    )
                                }


                            </tbody>


                        </Table>


                    </div>

            </div>



        )
    }

}

export default ListModulesComponent