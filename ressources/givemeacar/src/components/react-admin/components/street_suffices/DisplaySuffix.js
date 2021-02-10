import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const SuffixFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplaySuffix = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.suffices')} filters={<SuffixFilter />} exporter={false} perPage={25}>
        <Datagrid rowClick="edit" hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplaySuffix