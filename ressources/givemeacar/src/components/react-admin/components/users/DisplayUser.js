import {
    Datagrid, Filter, List, SearchInput, SingleFieldList, ChipField, ArrayField, TextField, EmailField, BooleanField, ReferenceField, useTranslate
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
        <Datagrid rowClick="edit" >

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <ArrayField label={t('custom.roles')} source="roles">
                <SingleFieldList>
                    <ChipField label={t('custom.name')} source="name" />
                </SingleFieldList>
            </ArrayField>


            <TextField label={t('custom.phone')} source="phone" />

            <TextField label={t('custom.address')} source="address" />

            <TextField label={t('custom.agency')} source="agencyName" />

            <BooleanField label={t('custom.enabled')} source="enabled" />
        </Datagrid>
    </List>
}

export default DisplayUser;