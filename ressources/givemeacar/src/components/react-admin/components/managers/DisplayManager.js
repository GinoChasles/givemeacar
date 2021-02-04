import {
    Datagrid, Filter, List, SearchInput, TextField, ReferenceField, EmailField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayManager = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.manager')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.phone')} source="phone" />

            <ReferenceField link='show' label={t('custom.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
}
export default DisplayManager