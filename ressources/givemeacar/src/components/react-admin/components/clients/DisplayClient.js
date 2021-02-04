import { Datagrid, Filter, List, SearchInput, TextField, useTranslate } from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayClient = (props) => {

    const t = useTranslate();

    return <List {...props} title="Liste des clients" filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <TextField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.password')} source="password" />

            <TextField label={t('custom.phone')} source="phone" />

            <TextField label={t('custom.address')} source="address" />

            <TextField label={t('custom.agency')} source="agencyName" />

        </Datagrid>
    </List>
}

export default DisplayClient