import {Datagrid, List, ReferenceField, TextField} from "react-admin";
import * as React from "react";

const DisplayDepartments = (props) => (
    <List {...props} title="Le département">
        <Datagrid rowClick="edit">
            <TextField source="code" />
            <TextField source="name" />
            <ReferenceField source="region_id" reference="regions">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
);

export default DisplayDepartments