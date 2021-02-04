import {
    Datagrid, EmailField, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";

import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayAdministrators = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.administrators')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <EmailField label={t('word.mail')} source="mail" />

            <TextField label={t('word.phone')} source="phone" />
        </Datagrid>
    </List>
}

export default DisplayAdministrators