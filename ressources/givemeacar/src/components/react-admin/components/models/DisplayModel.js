import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="brand_id" reference="brands" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);
const DisplayModel = (props) => (
    <List {...props} title="Modèles">
        <Datagrid rowClick="edit">
            <TextField source="name" />
            <TextField source="brandName" />
        </Datagrid>
    </List>
);
export default DisplayModel