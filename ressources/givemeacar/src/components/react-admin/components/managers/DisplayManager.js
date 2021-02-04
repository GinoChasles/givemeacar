import {
    Datagrid, EmailField, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayManager = (props) => {

    const t = useTranslate();

    return <List {...props} title="les managers" filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.phone')} source="phone" />

            <TextField label={t('custom.agency')} source="agencyName" />
        </Datagrid>
    </List>
}
export default DisplayManager