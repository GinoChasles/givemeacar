import {Datagrid, EmailField, Filter, List, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayManager = (props) => (
    <List {...props} title="les managers" filters={<PostFilter/>}>
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