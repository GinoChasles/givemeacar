import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const StreetFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayStreet = (props) => {

    const t = useTranslate()

    return <List {...props} title={t('word.streets')} filters={<StreetFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayStreet