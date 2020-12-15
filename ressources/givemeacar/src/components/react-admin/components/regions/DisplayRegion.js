import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayRegion = (props) => (
    <List {...props} title="La région" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayRegion