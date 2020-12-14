import {Datagrid, EmailField, List, TextField} from "react-admin";
import * as React from "react";

const DisplayManager = (props) => (
    <List {...props} title="les managers">
        <Datagrid rowClick="edit">
            {/* <ReferenceField source="agencyId" reference="agencies" sortBy="agencies.name">
      <TextField source="name" /> //TODO afficher agences auquel le manager appartient
      </ReferenceField> */}
            <TextField source="id" />
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
        </Datagrid>
    </List>
);
export default DisplayManager