import {
    Datagrid,
    List,
    NumberField,
    TextField,
    Filter,
    SearchInput
} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <SearchInput source="zipcode" />
    </Filter>
);
const DisplayCity = (props) => (
    <List {...props} title="Liste des villes" filters={<PostFilter/>}>

        <Datagrid rowClick="edit">
            <TextField source="name" label={"name"}/>
            <TextField source="zipcode" label={"zipCode"}/>
            <NumberField source="departmentName" label={"department"}/>
            <NumberField source="regionName" label={"region"}/>

            {/* <ReferenceField source="departmentId" reference="departments" sortBy="departments.name">
      <TextField source="name" /> //TODO afficher le nom du département
      </ReferenceField> */}
        </Datagrid>
    </List>
);

export default DisplayCity