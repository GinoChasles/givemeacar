import {
    Datagrid, Filter, List, SearchInput, TextField, EmailField, ReferenceField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

import ShowClient from './ShowClient';

const ClientFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayClient = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.clients')} filters={<ClientFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show" expand={ShowClient}>

            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <ReferenceField link='show' label={t('word.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayClient;