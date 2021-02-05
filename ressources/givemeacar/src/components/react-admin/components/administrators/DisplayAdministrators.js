import {
    Datagrid, EmailField, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";

import * as React from "react";

const AdminFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayAdministrators = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.administrators')} filters={<AdminFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">

            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <EmailField label={t('word.mail')} source="mail" />

            <TextField label={t('word.phone')} source="phone" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayAdministrators