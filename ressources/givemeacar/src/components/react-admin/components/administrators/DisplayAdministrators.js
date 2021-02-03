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

    return <List {...props} title="les villes de l'eeenfer" filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />
            <TextField label={t('custom.firstName')} source="firstName" />
            <TextField label={t('custom.lastName')} source="lastName" />
            <EmailField label={t('custom.mail')} source="mail" />
            <TextField label={t('custom.phone')} source="phone" />
        </Datagrid>
    </List>
}

export default DisplayAdministrators