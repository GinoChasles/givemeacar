import {Datagrid, Filter, List, ReferenceField, ReferenceInput, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="region_id" reference="regions" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);
const DisplayDepartments = (props) => (
    <List {...props} title="Le département" filters={<PostFilter/>}>
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