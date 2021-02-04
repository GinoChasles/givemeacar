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

    return <List {...props} title={t('word.departments')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.code')} source="code" />

            <TextField label={t('word.name')} source="name" />

            <ReferenceField label={t('word.region')} source="region_id" reference="regions">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
}

export default DisplayDepartments