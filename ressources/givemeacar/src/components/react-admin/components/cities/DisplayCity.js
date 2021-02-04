import {
    Datagrid,
    List,
    ReferenceField,
    TextField,
    Filter,
    SearchInput,
    useTranslate
} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <SearchInput source="zipcode" />
    </Filter>
);
const DisplayCity = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.cities')} filters={<PostFilter />}>

        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />

            <TextField label={t('word.zipcode')} source="zipcode" />

            <ReferenceField link="show" label={t('word.department')} source="department_id" reference="departments">
                <TextField source="name" />
            </ReferenceField>
            <ReferenceField link="show" label={t('word.region')} source="regionId" reference="regions">
                <TextField source="name" />
            </ReferenceField>

        </Datagrid>
    </List>
}

export default DisplayCity