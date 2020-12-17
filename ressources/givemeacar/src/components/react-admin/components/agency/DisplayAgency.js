import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, TextInput} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="manager_id" reference="managers" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="city_id" reference="cities" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="street_id" reference="streets" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);
const DisplayAgency = (props) => (
    <List {...props} title="Agences" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="name"            label="name"       />
            <TextField source="fullAddress"     label="address"    />
            <TextField source="managerFullName" label="manager"    />
        </Datagrid>
    </List>
);

export default DisplayAgency