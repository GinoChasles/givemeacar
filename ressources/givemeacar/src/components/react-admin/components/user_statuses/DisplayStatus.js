import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayStatus = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.statuses')} filters={<PostFilter />} exporter={false} perPage={25}>
        <Datagrid rowClick="edit" hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayStatus