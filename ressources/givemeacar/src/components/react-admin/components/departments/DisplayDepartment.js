import {
    Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, ReferenceField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="region_id" reference="regions" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);

const DisplayDepartments = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.departments')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.code')} source="code" />

            <TextField label={t('custom.name')} source="name" />

            <ReferenceField label={t('custom.region')} source="region_id" reference="regions">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
}

export default DisplayDepartments