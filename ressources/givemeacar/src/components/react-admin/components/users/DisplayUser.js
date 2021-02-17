import {
    Datagrid, Filter, List, SearchInput, TextField, EmailField, BooleanField, ReferenceField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayUser = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.users')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.roles')} source="joinedRoles" />

            <BooleanField label={t('custom.enabled')} source="enabled" />

            <TextField label={t('custom.phone')} source="phone" />

            <TextField label={t('custom.address')} source="address" />

            <ReferenceField link='show' label={t('custom.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>

        </Datagrid>
    </List>
}

export default DisplayUser;