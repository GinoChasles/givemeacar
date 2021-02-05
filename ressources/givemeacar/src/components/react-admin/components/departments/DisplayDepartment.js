import {
    Datagrid, Filter, List, SearchInput, TextField, ReferenceField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayDepartments = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.departments')} filters={<PostFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.code')} source="code" />

            <TextField label={t('word.name')} source="name" />

            <ReferenceField label={t('word.region')} source="region_id" reference="regions">
                <TextField source="name" />
            </ReferenceField>

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayDepartments