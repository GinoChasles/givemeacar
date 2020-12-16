import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayStreet = (props) => (
    <List {...props} filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="city_id" />
            <TextField source="street_name_id" />
        </Datagrid>
    </List>
);
export default DisplayStreet